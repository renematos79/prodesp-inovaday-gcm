package br.com.prodesp.inovadaygcm;

import java.util.Date;

/**
 * Created by root on 26/10/16.
 */

public class NotificacaoModel {

    public String Mensagem;
    public String DataEnvio;
    public String DataLeitura;

    public NotificacaoModel(String mensagem){
        this.Mensagem = mensagem;
        this.DataEnvio = ConvertHelper.ToString(new Date());
        this.DataLeitura = "";
    }

}
