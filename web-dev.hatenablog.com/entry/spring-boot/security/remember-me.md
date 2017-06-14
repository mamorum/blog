---
Title: SpringBoot：Remember-Me 認証を使う
Category:
- SpringBoot
Date: 2015-04-25T23:00:00+09:00
URL: http://web-dev.hatenablog.com/entry/spring-boot/security/remember-me
EditURL: https://blog.hatena.ne.jp/mamorums/web-dev.hatenablog.com/atom/entry/10328749687179332433
---

Remember-Me 認証は、ログイン状態を長期間保持する認証です。この認証をすると、ブラウザを閉じても認証している状態が保持されます。ユーザは、ブラウザを再起動してアクセスしても、再度認証する必要がありません。

色々な Web サービスで実装されていて、例えば Google アカウントの認証でも、ログイン状態を保持することができます。

![google-account-auth](http://cdn-ak.f.st-hatena.com/images/fotolife/m/mamorums/20160816/20160816123826.png)

これから、Spring Boot アプリで Remember-Me 認証を使う手順を書いていきます。


## 手順1. セキュリティ設定クラスの作成
次のような Java クラスを作成して、Remember-Me 認証を有効にします。

```java
@Configuration @EnableWebMvcSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired private DataSource dataSource;

    @Override
    protected void configure(HttpSecurity http) throws Exception {

        http
            .authorizeRequests()
                .antMatchers(
                  "/", "/css/**", "/js/**", "/lib/**"
                ).permitAll()
                .anyRequest().authenticated()
                .and()
            .formLogin()
                .loginPage("/login")
                .defaultSuccessUrl("/customer").permitAll()
                .and()
            .logout()
                .permitAll()
                .and()
            // ↓ Remember-Me 認証を有効化
            .rememberMe()
            	// DBにトークンを保存する。
            	.tokenRepository(jdbcTokenRepository())
            	// 状態を１ヵ月間保持する。
            	.tokenValiditySeconds(2592000);
    }

    @Bean public PersistentTokenRepository jdbcTokenRepository() {
    	JdbcTokenRepositoryImpl repository = new JdbcTokenRepositoryImpl();
    	repository.setDataSource(dataSource);
    	return repository;
    }
}
```

Remember-Me 認証で使うトークンは、RDB に保存されます（要 RDB 接続）。


## 手順2. ログイントークンのテーブル作成
次の SQL で作成します。

```sql
create table persistent_logins (
	username varchar(64) not null,
	series varchar(64) primary key,
	token varchar(64) not null,
	last_used timestamp not null
);
```

この SQL は、Spring Security のリファレンスに掲載されています。


## 手順3. ログイン画面に項目追加
アプリのログイン画面に、チェックボックス（ログイン情報を保持するかどうかの選択肢）を追加します。チェックボックスの例は次の通りです。

```html
<label><input type="checkbox" name="remember-me"> ログイン状態を保持する</label>
```

name属性は "remember-me" として、ログイン情報（ユーザ名やパスワード）と一緒に送信できるようにします。


## 補足：認証トークンをメモリに保存する方法
トークンをメモリに保存させるには、セキュリティ設定の一部を次のように変更します。

```java
// ↓ Remember-Me 認証を有効化
.rememberMe()
  	// メモリにトークンを保持する。
  	.tokenRepository(new InMemoryTokenRepositoryImpl())
  	// 状態を１ヵ月間保持する。
  	.tokenValiditySeconds(2592000);
```


## 実装例
以下のサンプルアプリで、Remember-Me 認証を実装しています。

[sbb  - GitHub](https://github.com/mamorum/blog/tree/master/code/sbb)
