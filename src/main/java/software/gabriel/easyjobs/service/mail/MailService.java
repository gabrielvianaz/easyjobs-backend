/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package software.gabriel.easyjobs.service.mail;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import software.gabriel.easyjobs.exception.mail.ErroEnvioEmailException;

/**
 *
 * @author gabriel
 */
@Service
public class MailService {

    @Autowired
    private JavaMailSender mailSender;

    public void enviar(String destinatario, String assunto, String html) {
        try {
            MimeMessage mimeMessage = mailSender.createMimeMessage();
            MimeMessageHelper messageHelper = new MimeMessageHelper(mimeMessage, "UTF-8");
            messageHelper.setFrom(MailUtils.DEFAULT_MAIL_FROM);
            messageHelper.setTo(destinatario);
            messageHelper.setSubject(assunto);
            messageHelper.setText(html, true);
            mailSender.send(mimeMessage);
        } catch (MessagingException e) {
            throw new ErroEnvioEmailException();
        }
    }

}
