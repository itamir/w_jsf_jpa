package br.ufrn.imd.material.repositorios;

import java.util.ArrayList;
import java.util.List;

import br.ufrn.imd.material.dominio.Material;

public class MaterialRepositorio {

	public static List<Material> materiais;
	
	public static void adicionar(Material material) {
		if(materiais == null) materiais = new ArrayList<Material>();
		materiais.add(material);
	}
	
	public static void remover(Material material) {
		materiais.remove(material);
	}
	
	public static List<Material> listarMateriais() {
		return materiais;
	}
}
