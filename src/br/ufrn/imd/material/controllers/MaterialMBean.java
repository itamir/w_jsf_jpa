package br.ufrn.imd.material.controllers;

import java.io.Serializable;

import javax.enterprise.context.SessionScoped;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;
import javax.inject.Inject;
import javax.inject.Named;

import br.ufrn.imd.material.dominio.Material;
import br.ufrn.imd.material.repositorios.MaterialRepositorio;

@Named
@SessionScoped
public class MaterialMBean implements Serializable {

	private Material material;
	
	private DataModel<Material> materiaisModel;
	
	@Inject
	private UsuarioMBean usuarioMBean;
	
	public MaterialMBean() {
		material = new Material();
	}
	public String novoMaterial() {
		material = new Material();
		return "/pages/material/form.jsf";
	}	
	public String listarMateriais() {
		materiaisModel = new ListDataModel<Material>
		(MaterialRepositorio.listarMateriais());
		return "/pages/material/list.jsf";
	}
	public String cadastrarMaterial() {
		material.setUsuarioCadastro(usuarioMBean.getUsuarioLogado());
		MaterialRepositorio.adicionar(material);
		material = new Material();
		return "/pages/material/form.jsf";
	}
	public String removerMaterial() {
		Material materialRemovido = materiaisModel.getRowData();
		MaterialRepositorio.remover(materialRemovido);
		return listarMateriais();
	}
	
	public Material getMaterial() {
		return material;
	}

	public void setMaterial(Material material) {
		this.material = material;
	}

	public DataModel<Material> getMateriaisModel() {
		return materiaisModel;
	}

	public void setMateriaisModel(DataModel<Material> materiaisModel) {
		this.materiaisModel = materiaisModel;
	}

}
