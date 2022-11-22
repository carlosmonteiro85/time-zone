package br.com.acme.fakeecomerce.timezone.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

import javax.servlet.http.HttpServletResponse;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.xhtmlrenderer.layout.SharedContext;
import org.xhtmlrenderer.pdf.ITextRenderer;

import br.com.acme.fakeecomerce.timezone.domain.model.Cart;
import br.com.acme.fakeecomerce.timezone.domain.model.Checkout;
import br.com.acme.fakeecomerce.timezone.domain.model.NfDTO;
import br.com.acme.fakeecomerce.timezone.domain.service.UserService;

public final class Utils {
    
    public static Integer totalItensCarrinho(UserService service) {
        return service.obtemUsuario().getCart().getCartItens().size();
    }

    public static Cart obterCarrinho(UserService service) {
        return service.obtemUsuario().getCart();
    }

    public static Checkout verificarCheck(Cart cart) {
        return new Checkout(cart);
    }

    public static String gerarNF(NfDTO nf) {
        File inputHTML = new File(AppConstantes.NF_MODEL);

        String nfTela = "";
        String pathFile = System.getProperty("java.io.tmpdir")+ System.getProperty("file.separator")  + "teste.pdf";

        try {
            Document document = Jsoup.parse(inputHTML, "UTF-8");
            document.outputSettings().syntax(Document.OutputSettings.Syntax.xml);
            nfTela = bindNf(document.html(), nf);
            
            OutputStream outStream = new FileOutputStream(pathFile);
            ITextRenderer renderer = new ITextRenderer();
            
            SharedContext sharedContext = renderer.getSharedContext();
            sharedContext.setPrint(true);
            sharedContext.setInteractive(false);
            renderer.setDocumentFromString(nfTela);
            renderer.layout();
            renderer.createPDF(outStream);
            renderer.finishPDF();
            outStream.close();
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return pathFile;
    }

    public static void downloadNF(String pathFile , HttpServletResponse response) {
        
        File file = new File(pathFile);
        final int BUFFER_SIZE = 4096;
        FileInputStream is;
        try {
            is = new FileInputStream(file);
            response.setContentType("application/pdf");
            response.setHeader("Content-disposition", "attachment; filename="+ System.currentTimeMillis() +".pdf");
            OutputStream out = response.getOutputStream();
            byte[] buffer = new byte[BUFFER_SIZE];
            int bytesRead = -1;
            while ((bytesRead = is.read(buffer)) != -1 ) {
                out.write(buffer, 0 , bytesRead);
            }
            is.close();
            out.close();
            
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    public static String bindNf(String htmlNf, NfDTO nf) {
        return htmlNf
                .replace("[ds_client_ie]", nf.getIncricaoEstadual())
                .replace("[ds_client_uf]", nf.getUf())
                .replace("[ds_danfe]", nf.getDsDanfe())
                .replace("[ds_client_receiver_name]", nf.getNomeDestinatario())
                .replace("[dt_invoice_issue]", nf.getDtEmissao().toString())
                .replace("[ds_client_neighborhood]", nf.getBairro())
                .replace("[nu_client_cep]", nf.getCep())
                .replace("[ds_client_city_name]", nf.getLocalidade())
                .replace("[nl_client_phone_number]", nf.getTelefone())
                .replace("[vl_shipping]", nf.getCheckout().getFrete().toString())
                .replace("[vl_total_prod]", nf.getCheckout().getSubtotal().toString())
                .replace("[vl_total]", nf.getCheckout().getTotal().toString())
                .replace("[dt_input_output]", nf.getDataSaida().toString())
                .replace("[nl_invoice]", nf.getNlInvoice())
                .replace("[ds_invoice_serie]", nf.getDsInvoiceSerie())
                .replace("[BARCODE]", nf.getBarCode())
                .replace("[ds_protocol]", nf.getProtocolLabel())
                .replace("[ds_client_address]", nf.getLogradouro());
    }
}
