package br.com.drogaria.bean;

import br.com.drogaria.dao.FabricanteDAO;
import br.com.drogaria.domain.Fabricante;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.model.ListDataModel;

@ManagedBean(name = "MBFabricante")
@ViewScoped
public class FabricanteBean {
    private ListDataModel<Fabricante> itens;

    public ListDataModel<Fabricante> getItens() {
        return itens;
    }

    public void setItens(ListDataModel<Fabricante> itens) {
        this.itens = itens;
    }
    
    @PostConstruct
    public void prepararPesquisa() {
        try{
            FabricanteDAO dao = new FabricanteDAO();
            ArrayList<Fabricante> lista = dao.listar();
            itens = new ListDataModel<Fabricante>(lista);
        }catch(SQLException ex){
            ex.printStackTrace();
        }
    }
    
}
