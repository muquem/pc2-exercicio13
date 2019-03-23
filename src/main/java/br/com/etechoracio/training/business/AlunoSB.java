package br.com.etechoracio.training.business;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import br.com.etechoracio.common.business.BaseSB;
import br.com.etechoracio.training.dao.AlunoDAO;
import br.com.etechoracio.training.model.Aluno;

@Service
public class AlunoSB extends BaseSB {

	private AlunoDAO AlunoDAO;

	@Override
	protected void postConstructImpl() {
		AlunoDAO = getDAO(AlunoDAO.class);

	}

	@Transactional(propagation = Propagation.REQUIRED)
	public void save(Aluno aluno) {
		AlunoDAO.save(aluno);
	}

}
