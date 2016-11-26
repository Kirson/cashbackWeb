package com.cashback.controller;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import org.primefaces.model.menu.DefaultMenuItem;
import org.primefaces.model.menu.DefaultMenuModel;
import org.primefaces.model.menu.DefaultSubMenu;
import org.primefaces.model.menu.MenuModel;

import com.cashback.interfaces.IMenu;
import com.cashback.interfaces.IMenuPerfil;
import com.cashback.model.Menu;
import com.cashback.model.Usuario;
import java.io.Serializable;

@SessionScoped
@ManagedBean
public class MenuCtr implements Serializable {

    private MenuModel menuModel;
    private Usuario usuario;

    @EJB
    private IMenuPerfil sMenuPerfil;
    @EJB
    private IMenu sMenu;

    public MenuCtr() {
        usuario = (Usuario) FacesContext.getCurrentInstance()
                .getExternalContext().getSessionMap().get("usuario");
    }

    @PostConstruct
    public void inicio() {
        recuperarMenuList();
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public String recuperarMenuList() {
        menuModel = new DefaultMenuModel();
        // First submenu
        DefaultSubMenu firstSubmenu = new DefaultSubMenu("Mantenimiento");

        Menu menu01 = sMenu.recuperarMenu("MANTENIMIENTO:PERSONAS");
        DefaultMenuItem item01 = new DefaultMenuItem("Personas");
        item01.setUrl(menu01.getMenUrl());
        item01.setIcon("ui-icon-person");
        item01.setRendered(sMenuPerfil.recuperarMenu(usuario.getPerfil(),
                menu01) != null);
        firstSubmenu.addElement(item01);

        Menu menu02 = sMenu.recuperarMenu("MANTENIMIENTO:CATEGORIA");
        DefaultMenuItem item02 = new DefaultMenuItem("Categoria");
        item02.setUrl(sMenu.recuperarMenu("MANTENIMIENTO:CATEGORIA")
                .getMenUrl());
        item02.setIcon("ui-icon-lightbulb");
        item02.setRendered(sMenuPerfil.recuperarMenu(usuario.getPerfil(),
                menu02) != null);
        firstSubmenu.addElement(item02);

        Menu menu03 = sMenu.recuperarMenu("MANTENIMIENTO:LOCALVENTA");
        DefaultMenuItem item03 = new DefaultMenuItem("Locales");
        item03.setUrl(sMenu.recuperarMenu("MANTENIMIENTO:LOCALVENTA")
                .getMenUrl());
        item03.setRendered(sMenuPerfil.recuperarMenu(usuario.getPerfil(),
                menu03) != null);
        item03.setIcon("ui-icon-home");
        firstSubmenu.addElement(item03);

        Menu menu04 = sMenu.recuperarMenu("MANTENIMIENTO:HOBBIE");
        DefaultMenuItem item04 = new DefaultMenuItem("Hobbie");
        item04.setUrl(sMenu.recuperarMenu("MANTENIMIENTO:HOBBIE").getMenUrl());
        item04.setIcon("ui-icon-video");
        item04.setRendered(sMenuPerfil.recuperarMenu(usuario.getPerfil(),
                menu04) != null);
        firstSubmenu.addElement(item04);

        Menu menu05 = sMenu.recuperarMenu("MANTENIMIENTO:PROVINCIA");
        DefaultMenuItem item05 = new DefaultMenuItem("Provincia");
        item05.setUrl(sMenu.recuperarMenu("MANTENIMIENTO:PROVINCIA")
                .getMenUrl());
        item05.setIcon("ui-icon-image");
        item05.setRendered(sMenuPerfil.recuperarMenu(usuario.getPerfil(),
                menu05) != null);
        firstSubmenu.addElement(item05);

        Menu menu06 = sMenu.recuperarMenu("MANTENIMIENTO:USUARIO");
        DefaultMenuItem item06 = new DefaultMenuItem("Usuario");
        item06.setUrl(sMenu.recuperarMenu("MANTENIMIENTO:USUARIO").getMenUrl());
        item06.setIcon("ui-icon-image");
        item06.setRendered(sMenuPerfil.recuperarMenu(usuario.getPerfil(),
                menu06) != null);
        firstSubmenu.addElement(item06);

        Menu menu07 = sMenu.recuperarMenu("MANTENIMIENTO:ACTOR");
        DefaultMenuItem item07 = new DefaultMenuItem("Actor");
        item07.setUrl(menu07.getMenUrl());
        item07.setIcon("ui-icon-image");
        item07.setRendered(sMenuPerfil.recuperarMenu(usuario.getPerfil(),
                menu07) != null);
        firstSubmenu.addElement(item07);

        DefaultSubMenu consultasSubmenu = new DefaultSubMenu("Consultas");

        Menu men08 = sMenu.recuperarMenu("CONSULTAS:CADENAVALOR");
        DefaultMenuItem item09 = new DefaultMenuItem("Cadena de Valor");
        item09.setUrl(men08.getMenUrl());
        item09.setIcon("ui-icon-person");
        item09.setRendered(sMenuPerfil.recuperarMenu(usuario.getPerfil(),
                men08) != null);
        consultasSubmenu.addElement(item09);

        Menu men10 = sMenu.recuperarMenu("CONSULTAS:ACTOR");
        DefaultMenuItem item10 = new DefaultMenuItem("Actor");
        item10.setUrl(men10.getMenUrl());
        item10.setIcon("ui-icon-person");
        item10.setRendered(sMenuPerfil.recuperarMenu(usuario.getPerfil(),
                men10) != null);
        consultasSubmenu.addElement(item10);

        Menu men11 = sMenu.recuperarMenu("CONSULTAS:PUNTOS");
        DefaultMenuItem item11 = new DefaultMenuItem("Puntos");
        item11.setUrl(men11.getMenUrl());
        item11.setIcon("ui-icon-person");
        item11.setRendered(sMenuPerfil.recuperarMenu(usuario.getPerfil(),
                men11) != null);
        consultasSubmenu.addElement(item11);
        /*
        Menu men12 = sMenu.recuperarMenu("CONSULTAS:DEMOPUNTOS");
        DefaultMenuItem item12 = new DefaultMenuItem("Puntos demo");
        item12.setUrl(men12.getMenUrl());
        item12.setIcon("ui-icon-person");
        item12.setRendered(sMenuPerfil.recuperarMenu(usuario.getPerfil(),
                men12) != null);
        consultasSubmenu.addElement(item12);
         */
        Menu men13 = sMenu.recuperarMenu("CONSULTAS:PUNTOSTRANSACCIONES");
        DefaultMenuItem item13 = new DefaultMenuItem("Transacciones Actor");
        item13.setUrl(men13.getMenUrl());
        item13.setIcon("ui-icon-person");
        item13.setRendered(sMenuPerfil.recuperarMenu(usuario.getPerfil(),
                men13) != null);
        consultasSubmenu.addElement(item13);
        
        Menu men14 = sMenu.recuperarMenu("CONSULTAS:PUNTOSTRANSACCIONESC");
        DefaultMenuItem item14 = new DefaultMenuItem("Transacciones Comprobante");
        item14.setUrl(men14.getMenUrl());
        item14.setIcon("ui-icon-person");
        item14.setRendered(sMenuPerfil.recuperarMenu(usuario.getPerfil(),
                men14) != null);
        consultasSubmenu.addElement(item14);
        
        Menu men15 = sMenu.recuperarMenu("CONSULTAS:VENTASLOCAL");
        DefaultMenuItem item15 = new DefaultMenuItem("Cierre Dia Local");
        item15.setUrl(men15.getMenUrl());
        item15.setIcon("ui-icon-person");
        item15.setRendered(sMenuPerfil.recuperarMenu(usuario.getPerfil(),
                men15) != null);
        consultasSubmenu.addElement(item15);
        
        Menu men16 = sMenu.recuperarMenu("CONSULTAS:CARGAPUNTOS");
        DefaultMenuItem item16 = new DefaultMenuItem("Carga de Puntos");
        item16.setUrl(men16.getMenUrl());
        item16.setIcon("ui-icon-person");
        item16.setRendered(sMenuPerfil.recuperarMenu(usuario.getPerfil(),
                men16) != null);
        consultasSubmenu.addElement(item16);

        menuModel.addElement(firstSubmenu);
        menuModel.addElement(consultasSubmenu);
        return null;
    }

    public MenuModel getMenuModel() {
        return menuModel;
    }

    public void setMenuModel(MenuModel menuModel) {
        this.menuModel = menuModel;
    }
}
