package sbb.model;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Version;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.Data;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity @Table(name="users") @Data
public class User {

	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
    private long id;

	@NotEmpty(message="{mail}{NotEmpty}")
	@Email(message="{mail}{Email}")
	@Size(max=50, message="{mail}{Max}")
	private String username;

	@NotEmpty(message="{password}{NotEmpty}")
    @Size(max=50, message="{password}{Max}")
	private String password;

	@NotNull(message="{enabled}{NotEmpty}")
	private boolean enabled;

	@NotEmpty(message="{authority}{NotEmpty}")
	private String authority;

	@JsonIgnore @Version private long version;

    @JsonIgnore @Column(insertable=false, updatable=false)
    private Timestamp createdTime;

	public void copyTo(User dst) {
		dst.setUsername(this.username);
		dst.setPassword(this.password);
		dst.setEnabled(this.enabled);
		dst.setAuthority(this.authority);
	}
}
