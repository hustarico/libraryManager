package com.hustarico.config;

import com.hustarico.port.BookRepository;
import com.hustarico.port.MemberRepository;
import com.hustarico.services.BookService;
import com.hustarico.services.MemberService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    @Bean
    public BookService bookService(BookRepository bookRepository, MemberRepository memberRepository){
        return new BookService(bookRepository,memberRepository);
    }

    @Bean
    public MemberService memberService(MemberRepository memberRepository){
        return new MemberService(memberRepository);
    }
}
