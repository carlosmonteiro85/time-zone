package br.com.acme.fakeecomerce.timezone.domain.model;

import java.time.LocalDate;
import java.util.Random;

import br.com.acme.fakeecomerce.timezone.api.dto.CheckoutDTO;
import lombok.Getter;
import lombok.Setter;

public class NfDTO {
    @Setter
    @Getter
    private CheckoutDTO checkout;
    // [nl_invoice]
    @Getter
    private String nlInvoice =  String.valueOf(new Random().nextInt(9999));
    // {BarCode}
    @Getter
    private String barCode = String.valueOf(new Random().nextInt(99999999));
    // [ds_invoice_serie]
    @Getter
    @Setter
    private String dsInvoiceSerie = String.valueOf(new Random().nextInt(99999999));
    // [ds_danfe]
    @Getter
    private String dsDanfe =  String.valueOf(new Random().nextInt(9999)) ;
    // [protocol_label]
    @Getter
    private String protocolLabel = String.valueOf(new Random().nextInt(999999999));
    // [ds_client_receiver_name]
    @Getter
    @Setter
    private String nomeDestinatario;
    // [dt_invoice_issue]
    @Getter
    private LocalDate dtEmissao = LocalDate.now();
    // [ds_client_address]
    @Getter
    @Setter
    private String logradouro;
    // [ds_client_neighborhood]
    @Getter
    @Setter
    private String bairro;
    // [nu_client_cep]
    @Getter
    @Setter
    private String cep;
    // [dt_input_output]
    @Getter
    private LocalDate dataSaida = LocalDate.now().plusDays(3L);
    // [ds_client_city_name]
    @Getter
    @Setter
    private String localidade;
    // [nl_client_phone_number]
    @Getter
    @Setter
    private String telefone;
    // [ds_client_uf]
    @Getter
    @Setter
    private String uf;
    // [ds_client_ie]
    @Getter
    private String incricaoEstadual = String.valueOf(new Random().nextInt(99999999));
    @Getter
    @Setter
    private String email;
}
