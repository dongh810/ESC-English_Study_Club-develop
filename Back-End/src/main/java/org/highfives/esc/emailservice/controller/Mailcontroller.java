package org.highfives.esc.emailservice.controller;


import lombok.RequiredArgsConstructor;
import org.highfives.esc.emailservice.dto.EmailRequestDto;
import org.highfives.esc.emailservice.service.MailSendService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class Mailcontroller {

    private final MailSendService mailService;

    @PostMapping("/mailSend")
    public String mailSend(@RequestBody EmailRequestDto emailDto) {
        System.out.println("이메일 인증 이메일 :" + emailDto.getEmail());
        return mailService.joinEmail(emailDto.getEmail());
    }

}
