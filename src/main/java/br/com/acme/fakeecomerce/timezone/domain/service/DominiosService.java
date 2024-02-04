package br.com.acme.fakeecomerce.timezone.domain.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import br.com.acme.fakeecomerce.timezone.api.dto.CheckoutDTO;
import br.com.acme.fakeecomerce.timezone.api.dto.ItemCartDTO;
import br.com.acme.fakeecomerce.timezone.api.dto.ProdutoDTO;
import br.com.acme.fakeecomerce.timezone.api.dto.UserDTO;
import br.com.acme.fakeecomerce.timezone.api.mapper.CheckoutAssembler;
import br.com.acme.fakeecomerce.timezone.api.mapper.ProdutoAssembler;
import br.com.acme.fakeecomerce.timezone.domain.model.Cart;
import br.com.acme.fakeecomerce.timezone.domain.model.Checkout;
import br.com.acme.fakeecomerce.timezone.domain.model.Produto;
import br.com.acme.fakeecomerce.timezone.util.AppConstantes;
import br.com.acme.fakeecomerce.timezone.util.Utils;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class DominiosService {

  private final ProductService service;
  private final UserService userService;
  private final ProdutoAssembler mapper;
  private final CheckoutAssembler checkoutAssembler;

  public void getDominiosHome(Model model) {
    model.addAttribute(AppConstantes.PRODUTOS, service.findProdutos());
    model.addAttribute(AppConstantes.ITEM_CART, Utils.totalItensCarrinho(userService));
    model.addAttribute("itemCartDTO", new ItemCartDTO());
  }

  public void getDominiosShop(Model model) {
    List<ProdutoDTO> produtos = service.findProdutos();

    List<ProdutoDTO> produtosPorPreco = new ArrayList<>(produtos);
    Collections.sort(produtosPorPreco, Comparator.comparing(ProdutoDTO::getPreco));

    List<ProdutoDTO> maisPopulares = new ArrayList<>(produtos);
    Collections.sort(maisPopulares, Comparator.comparing(ProdutoDTO::getNome));

    model.addAttribute("produtos", produtos);
    model.addAttribute("produtosPorPreco", produtosPorPreco);
    model.addAttribute("maisPopulares", maisPopulares);
    model.addAttribute(AppConstantes.ITEM_CART, Utils.totalItensCarrinho(userService));
  }

  public void getDominiosObterPtoduto(Model model, Produto produto) {
    model.addAttribute("produto", produto);
    model.addAttribute("itemCartDTO", new ItemCartDTO(mapper.toDTO(produto)));
    model.addAttribute(AppConstantes.ITEM_CART, Utils.totalItensCarrinho(userService));
  }

  public void getDominiosConfirmacao(Model model, CheckoutDTO checkout, String pathNF) {
    model.addAttribute("pathNF", pathNF.replace("/", "-").replace("\\", "-"));
    model.addAttribute(AppConstantes.CHECKOUT, checkout);
  }

  public void getDominiosContatos(Model model) {
    model.addAttribute(AppConstantes.ITEM_CART, Utils.totalItensCarrinho(userService));
  }

  public void getDominiosCarrinho(Model model, Cart cart, Checkout checkout) {
    model.addAttribute(AppConstantes.CHECKOUT, checkoutAssembler.toDTO(checkout));
    model.addAttribute("userDTO", new UserDTO());
    model.addAttribute(AppConstantes.ITEM_CART, Utils.totalItensCarrinho(userService));
    model.addAttribute(AppConstantes.CART, cart);
  }
}
