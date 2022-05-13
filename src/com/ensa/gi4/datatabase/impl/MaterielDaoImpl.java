package com.ensa.gi4.datatabase.impl;

import com.ensa.gi4.datatabase.api.MaterielDao;
import com.ensa.gi4.modele.Materiel;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class MaterielDaoImpl extends GenericDAO<Materiel> implements MaterielDao {
    @Override
    public List<Materiel> findAll() {
        return super.findAll("SELECT * FROM MATERIEL;");
    }

    @Override
    public Materiel findOne(Long id) {
        return super.findOne("SELECT * FROM MATERIEL WHERE ID=?;", id);
    }

    @Override
    protected MaterielRowMapper getRowMapper() { // template method design pattern
    	
        return new MaterielRowMapper();
    }

	@Override
	public int addOne(Materiel m) {
		// TODO Auto-generated method stub
		return super.addOne("INSERT into MATERIEL (ID,name) VALUES (?,?)",Long.parseLong(m.getCode()),m.getName());
	}

	@Override
	public int deleteOne(Long id) {
		// TODO Auto-generated method stub
		return super.deleteOne("delete from employee where id = ?", id);
	}
	
}
