/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exercisetwoestancias.persistence;

import exercisetwoestancias.entities.Casa;
import exercisetwoestancias.entities.Familia;
import java.util.ArrayList;
import java.util.Collection;

/**
 *
 * @author Facundo
 */
public final class FamiliaDAO extends DAO {

    private CasaDAO casaDAO = new CasaDAO();

    /**
     * Method for saving a family
     *
     * @param familia
     * @throws Exception
     */
    public void saveFamily(Familia familia) throws Exception {
        try {
            if (familia == null) {
                throw new Exception("familia null");
            }
            String sql = "INSERT INTO familia (id_familia, nombre, edad_minima, edad_maxima, num_hijos, email, id_casa_familia) "
                    + "VALUES (" + familia.getIdFamilia() + ", '" + familia.getNombre() + "' , " + familia.getEdadMinima() + " , " + familia.getEdadMaxima() + " , " + familia.getNumHijos() + " , '" + familia.getEmail() + "' , " + familia.getCasa().getIdCasa() + ");";
            insertModifyDelete(sql);
        } catch (Exception e) {
            throw e;
        }
    }

    /**
     * List those families that have at least 3 children, and with a maximum age
     * of less than 10 years old. years old.
     *
     * @return familly
     * @throws Exception
     */
    public Collection<Familia> listBySon() throws Exception {
        try {
            String sql = "SELECT * FROM familias WHERE num_hijos < 3 AND edad_maxima < 10;";
            consult(sql);
            Collection<Familia> families = new ArrayList();
            Familia family = null;
            while (resultSet.next()) {
                family = new Familia();
                family.setIdFamilia(resultSet.getInt(1));
                family.setNombre(resultSet.getString(2));
                family.setEdadMinima(resultSet.getInt(3));
                family.setEdadMaxima(resultSet.getInt(4));
                family.setNumHijos(resultSet.getInt(5));
                family.setEmail(resultSet.getString(6));
                Casa casa = casaDAO.consultById(resultSet.getInt(7));
                if (casa == null) {
                    throw new Exception("House null");
                }
                family.setCasa(casa);
                families.add(family);
            }
            close();
            return families;
        } catch (Exception e) {
            throw e;
        }
    }

    /**
     * Method that finds all the families whose e-mail address is Hotmail.
     *
     * @return families
     * @throws Exception
     */
    public Collection<Familia> listByEmail() throws Exception {
        try {
            String sql = "SELECT * FROM familias WHERE email LIKE '%hotmail%'";
            consult(sql);
            Collection<Familia> families = new ArrayList<>();
            Familia family = null;
            while (resultSet.next()) {
                family = new Familia();
                family.setIdFamilia(resultSet.getInt(1));
                family.setNombre(resultSet.getString(2));
                family.setEdadMinima(resultSet.getInt(3));
                family.setEdadMaxima(resultSet.getInt(4));
                family.setNumHijos(resultSet.getInt(5));
                family.setEmail(resultSet.getString(6));
                Casa casa = casaDAO.consultById(resultSet.getInt(7));
                if (casa == null) {
                    throw new Exception("House null");
                }
                family.setCasa(casa);
                families.add(family);
            }
            close();
            return families;
        } catch (Exception e) {
            throw e;
        }
    }
}
