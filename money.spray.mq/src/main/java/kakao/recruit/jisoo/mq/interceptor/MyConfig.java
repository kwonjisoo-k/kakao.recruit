package kakao.recruit.jisoo.mq.interceptor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import kakao.recruit.jisoo.mq.interceptor.AuthenticationInterceptor;
@Configuration 
public class MyConfig implements WebMvcConfigurer  {

    @Autowired
    private AuthenticationInterceptor authenticationInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
    	System.out.println("Interceptors");
        registry.addInterceptor(authenticationInterceptor)
            // path가 /user/me인 요청에 대해서만 적용
            .addPathPatterns("/**");
    }
}