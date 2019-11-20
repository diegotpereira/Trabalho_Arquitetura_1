package br.edu.qi.email;

import java.io.UnsupportedEncodingException;
import java.util.Arrays;
import java.util.Properties;

import javax.activation.DataHandler;
import javax.mail.Address;
import javax.mail.AuthenticationFailedException;
import javax.mail.Authenticator;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

import br.edu.qi.email.MeuAutenticador;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

//Controle de Eventos da JanelaEnviar
public class EventoEnviarEmail implements EventHandler<ActionEvent>{

	
	
	String hostServer;
	String para;
	String de;
	String assunto;
	String username;	
	String senha;
	String conteudoMensagem;
	
	ArquivoModel[] anexos; 
	
	public void handle(ActionEvent event) {
		// TODO Auto-generated method stub
		
		
	
	}
	
	private void enviarEmail() throws AddressException, MessagingException, UnsupportedEncodingException {
		
		// TODO Auto-generated method stub
		Authenticator authenticator = new MeuAutenticador(username, senha);
		
		//configura objeto properties
		Properties props = new Properties();
		props.put("mail.smtp.host", hostServer);				
		props.put("mail.smtp.socketFactory.port", "465");	//porta ssl
		props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory"); //especifica classe para criar SMTP Socket
		props.put("mail.smtp.auth", "true");	//autenticação requerida		
		
		//obtem um objeto Session sob as credenciais e propriedades especificadas
		Session session = Session.getInstance(props, authenticator);
		
		//cria uma mensagem vazia
		Message mensagem = new MimeMessage(session);
		
		//configura os campos da mensagem
		Address enderecoDe = new InternetAddress(username, de);	//address except
		Address enderecoPara = new InternetAddress(para);
		
		mensagem.setFrom(enderecoDe);	//messaging excep
		mensagem.setRecipient(Message.RecipientType.TO, enderecoPara);
		mensagem.setSubject(assunto);		
		
		//método encarregado de anexar os arquivos na mensagem
		anexarArquivos(mensagem, anexos);
		
		//envia a mensagem
		Transport.send(mensagem);		//auth failed except
	}
	
	//método auxliar para anexar arquivos na mensagem
	private void anexarArquivos(Message mensagem, ArquivoModel[] arquivos) throws MessagingException {
		
		//Multipart é o container de partes da mensagem
		Multipart multipart = new MimeMultipart();		
		
		//uma parte específca da mensagem
		BodyPart messageBodyPart = new MimeBodyPart();
		
		//DataHandler para operações diversas nos diferentes tipos de dados
		DataHandler dataHandler = null;
		
		//partew do texto da mensagem
		messageBodyPart.setText(conteudoMensagem);
		
		//adicona o texto ao multipart
		multipart.addBodyPart(messageBodyPart);
							
		//loop: cria um BodyPart para cada anexo e adiciona-o no Multipart 
		for(ArquivoModel anexo : arquivos) {
			
			dataHandler = new DataHandler(anexo.getConteudo(), anexo.getMimeType());
			messageBodyPart = new MimeBodyPart();									
			messageBodyPart.setDataHandler(dataHandler);
			messageBodyPart.setFileName(anexo.getNomeArquivo());
			multipart.addBodyPart(messageBodyPart);
		}
		
		//vincula o Multipart na mensagem
		mensagem.setContent(multipart);
	}

	
}
