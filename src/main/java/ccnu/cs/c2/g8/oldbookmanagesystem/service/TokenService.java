package ccnu.cs.c2.g8.oldbookmanagesystem.service;

import ccnu.cs.c2.g8.oldbookmanagesystem.data.entity.User;
import com.auth0.jwt.JWT;
import org.springframework.stereotype.Service;
import com.auth0.jwt.algorithms.Algorithm;


@Service("TokenService")
public class TokenService {

    public String getToken(User user) {
        String token="";
        token= JWT.create().withAudience(user.getUno().toString())// 将 user id 保存到 token 里面
                .sign(Algorithm.HMAC256(user.getUpassword()));// 以 password 作为 token 的密钥
        return token;
    }
}
