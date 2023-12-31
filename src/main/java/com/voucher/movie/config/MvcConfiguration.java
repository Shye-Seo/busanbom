//package com.voucher.movie.config;
//
//import java.util.concurrent.TimeUnit;
//
//import org.springframework.context.annotation.Configuration;
//import org.springframework.http.CacheControl;
//import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
//import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
//import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
//
//@Configuration
//public class MvcConfiguration implements WebMvcConfigurer {
//
//
//	@Override
//    public void addResourceHandlers(final ResourceHandlerRegistry registry) {
//        registry.addResourceHandler("/**")
//                .addResourceLocations("classpath:/templates/", "classpath:/static/")
//                .setCacheControl(CacheControl.maxAge(10, TimeUnit.MINUTES));
//    }
//	
//	@Override
//	public void addInterceptors(InterceptorRegistry registry) {
//		registry.addInterceptor(new WebInterceptor()) // LogInterceptor 등록
//				.order(1)	// 적용할 필터 순서 설정
//				.addPathPatterns("/**")
//				.excludePathPatterns("/error"); // 인터셉터에서 제외할 패턴
//		
//		registry.addInterceptor(new AuthorityCheckInterceptor()) //LoginCheckInterceptor 등록
//		.order(2)
//		.addPathPatterns("/admin_*", "/admin*")
//		.excludePathPatterns("/museum_*","/reservation_*","/main","/imgs/**", "/js/**", "/css/**");
//	}
//}