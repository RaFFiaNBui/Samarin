package Auth;

import javax.annotation.Nullable;

public interface AuthService {

    void start();
    void stop();

    /**
     *
     * @param login
     * @param pass
     * @return nick or null
     */ /*пишем javaDoc или подключакем Nullable в pom*/
    @Nullable
    String getNickByLoginPass (String login, String pass);
}
