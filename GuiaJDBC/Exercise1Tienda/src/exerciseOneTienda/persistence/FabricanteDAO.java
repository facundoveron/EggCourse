/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exerciseOneTienda.persistence;

import exerciseOneTienda.entities.Fabricante;

/**
 *
 * @author Facundo
 */
public final class FabricanteDAO extends DAO{
    
    /**
     * Enter a manufacturer in the database
     * 
     * @param fabricante
     * @throws Exception 
     */
    public void saveManufacturer(Fabricante fabricante) throws Exception{
        try {
            if(fabricante == null){
                throw new Exception("fabricante null");
            }
            
            String sql = "INSERT INTO fabricante (codigo, nombre)"
                    + " VALUES ( "+ fabricante.getCodigo() + ", '" + fabricante.getNombre() + "' );";
            
            insertModifyDelete(sql);
        } catch (Exception e) {
            throw e;
        }
    }
    
    
    /**
     * Method to search by code
     * 
     * @param code
     * @return fabricante
     * @throws Exception 
     */
    public Fabricante searchByCode(Integer code) throws Exception{
        try {
            if(code == null){
                throw new Exception("Code null");
            }
            String sql = "SELECT * FROM fabricante WHERE codigo = " + code;
            consult(sql);
            Fabricante fabricante = null;
            while(resultSet.next()){
                fabricante = new Fabricante();
                fabricante.setCodigo(resultSet.getInt(1));
                fabricante.setNombre(resultSet.getString(2));
            }
            return fabricante;
        } catch (Exception e) {
            throw e;
        }
    }
}
