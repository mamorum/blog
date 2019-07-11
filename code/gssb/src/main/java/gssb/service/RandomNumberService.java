package gssb.service;

import org.springframework.stereotype.Service;

@Service  // サービスクラスに付与。
public class RandomNumberService {

  // 整数0-9の乱数を返却。
  public int zeroToNine() {
    return (int) (Math.random() * 10);
  }
}
