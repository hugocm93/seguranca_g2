package Util;

import java.util.ArrayList;

import model.Message;

public class MessageManager {
	
	private static MessageManager instance = null;
	private static ArrayList<Message> messages = null;

	public static MessageManager getInstance() {
		if (instance == null) {
			instance = new MessageManager();
		}
		return instance;
	}
	
	public String getMessage(int id) {
		for(Message m : messages) {
			if(m.id == id) {
				return m.message;
			}
		}
		
		return null;
	}
	
	protected MessageManager() {
		messages = new ArrayList<Message>();
		
		messages.add(new Message(1001,"Sistema iniciado."));
		messages.add(new Message(1002,"Sistema Sistema encerrado."));
		
		messages.add(new Message(2001,"Autenticação etapa 1 iniciada."));
		messages.add(new Message(2002,"Autenticação etapa 1 encerrada."));
		messages.add(new Message(2003,"Login name <login_name> identificado com acesso liberado."));
		messages.add(new Message(2004,"Login name <login_name> identificado com acesso bloqueado."));
		messages.add(new Message(2005,"Login name <login_name> não identificado."));
		
		messages.add(new Message(3001,"Autenticação etapa 2 iniciada para <login_name>."));
		messages.add(new Message(3002,"Autenticação etapa 2 encerrada para <login_name>."));
		messages.add(new Message(3003,"Chave privada verificada positivamente para <login_name>."));
		messages.add(new Message(3004,"Chave privada verificada negativamente para <login_name> (caminho inválido)."));
		messages.add(new Message(3005,"Chave privada verificada negativamente para <login_name> (frase secreta inválida)."));
		messages.add(new Message(3006,"Chave privada verificada negativamente para <login_name> (assinatura digital inválida)."));
		messages.add(new Message(3007,"Primeiro erro da senha pessoal contabilizado para <login_name>."));
		messages.add(new Message(3008,"Segundo erro da senha pessoal contabilizado para <login_name>."));
		messages.add(new Message(3009,"Terceiro erro da senha pessoal contabilizado para <login_name>."));
		messages.add(new Message(3010,"Acesso do usuario <login_name> bloqueado pela autenticação etapa 2."));
		
		messages.add(new Message(4001,"Autenticação etapa 3 iniciada para <login_name>."));
		messages.add(new Message(4002,"Autenticação etapa 3 encerrada para <login_name>."));
		messages.add(new Message(4003,"Senha de única vez verificada positivamente para <login_name>."));
		messages.add(new Message(4004,"Primeiro erro da senha de única vez contabilizado para <login_name>."));
		messages.add(new Message(4005,"Segundo erro da senha de única vez contabilizado para <login_name>."));
		messages.add(new Message(4006,"Terceiro erro da senha de única vez contabilizado para <login_name>."));
		messages.add(new Message(4009,"Acesso do usuario <login_name> bloqueado pela autenticação etapa 3."));
		
		messages.add(new Message(5001,"Tela principal apresentada para <login_name>."));
		messages.add(new Message(5002,"Opção 1 do menu principal selecionada por <login_name>."));
		messages.add(new Message(5003,"Opção 2 do menu principal selecionada por <login_name>."));
		messages.add(new Message(5004,"Opção 3 do menu principal selecionada por <login_name>."));
		messages.add(new Message(5005,"Opção 4 do menu principal selecionada por <login_name>."));
		
		messages.add(new Message(6001,"Tela de cadastro apresentada para <login_name>."));
		messages.add(new Message(6002,"Botão cadastrar pressionado por <login_name>."));
		messages.add(new Message(6003,"Senha pessoal inválida fornecida por <login_name>."));
		messages.add(new Message(6004,"Caminho do certificado digital inválido fornecido por <login_name>."));
		messages.add(new Message(6005,"Confirmação de dados aceita por <login_name>."));
		messages.add(new Message(6006,"Confirmação de dados rejeitada por <login_name>."));
		messages.add(new Message(6007,"Botão voltar de cadastro para o menu principal pressionado por <login_name>."));
		
		messages.add(new Message(7001,"Tela de consulta da chave privada e certificado apresentada para <login_name>."));
		messages.add(new Message(7002,"Botão voltar de carregamento para o menu principal pressionado por <login_name>."));
		
		messages.add(new Message(8001,"Tela de consulta de arquivos secretos apresentada para <login_name>."));
		messages.add(new Message(8002,"Botão voltar de consulta para o menu principal pressionado por <login_name>."));
		messages.add(new Message(8003,"Botão Listar de consulta pressionado por <login_name>."));
		messages.add(new Message(8006,"Caminho de pasta inválido fornecido por <login_name>."));
		messages.add(new Message(8007,"Lista de arquivos apresentada para <login_name>."));
		messages.add(new Message(8008,"Arquivo <arq_name> selecionado por <login_name> para decriptação."));
		messages.add(new Message(8009,"Acesso permitido ao arquivo <arq_name> para <login_name>."));
		messages.add(new Message(8010,"Acesso negado ao arquivo <arq_name> para <login_name>."));
		messages.add(new Message(8011,"Arquivo <arq_name> decriptado com sucesso para <login_name>."));
		messages.add(new Message(8012,"Arquivo <arq_name> verificado (integridade e autenticidade) com sucesso para <login_name>."));
		messages.add(new Message(8013,"Falha na decriptação do arquivo <arq_name> para <login_name>."));
		messages.add(new Message(8014,"Falha na verificação (integridade e autenticidade) do arquivo <arq_name> para <login_name>."));
		
		messages.add(new Message(9001,"Tela de saída apresentada para <login_name>."));
		messages.add(new Message(9002,"Botão sair pressionado por <login_name>."));
		messages.add(new Message(9003,"Botão voltar de sair para o menu principal pressionado por <login_name>."));
	}
}
