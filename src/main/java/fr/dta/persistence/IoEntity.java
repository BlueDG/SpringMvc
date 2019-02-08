package fr.dta.persistence;

import java.io.Serializable;

public interface IoEntity extends Serializable {
	Long getId();

	void setId(Long id);
}