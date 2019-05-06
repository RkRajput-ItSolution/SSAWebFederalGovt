package com.ssa.federal.gov.service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssa.federal.gov.entity.SSAAppEntity;
import com.ssa.federal.gov.entity.SSAAppStateEntity;
import com.ssa.federal.gov.exception.SsaAppRestException;
import com.ssa.federal.gov.model.SSAAppModel;
import com.ssa.federal.gov.repository.SSAAppRepository;
import com.ssa.federal.gov.repository.SSAAppStateRepository;

@Service("service")
public class SSAAppServiceImpl implements SSAAppService {

	public SSAAppServiceImpl() {
		System.out.println("SSAAppServiceImpl.SSAAppServiceImpl()");
	}

	@Autowired
	private SSAAppRepository ssaRepository;

	@Autowired
	private SSAAppStateRepository ssaStateRepository;

	@Override
	public long SsaEnrollment(SSAAppModel ssnModel) throws IOException {
		System.out.println("SSAAppServiceImpl.SsaEnrollment()");
		// return ssaRepository.save(mapper.converterVoToDto(model)).getSsn();
		SSAAppEntity entity = new SSAAppEntity();

		BeanUtils.copyProperties(ssnModel, entity);

		entity.setPhoto(ssnModel.getPhoto().getBytes());
		entity = ssaRepository.save(entity);
		return entity.getSsn();

	}

	public List<SSAAppModel> retriveAllSsnRecord() {
		/*
		 * List<SSAAppModel> list = new ArrayList(); Iterable<SSAAppEntity> entity =
		 * ssaRepository.findAll(); Iterator<SSAAppEntity> itr = entity.iterator();
		 * while (itr.hasNext()) { SSAAppEntity e = itr.next(); SSAAppModel model = new
		 * SSAAppModel(); BeanUtils.copyProperties(e, model); list.add(model);
		 * 
		 * } return list;
		 */
		List<SSAAppModel> listDTO = new ArrayList();

		ssaRepository.findAll().forEach(bo -> {
			SSAAppModel dto = new SSAAppModel();
			BeanUtils.copyProperties(bo, dto);
			listDTO.add(dto);
		});
		return listDTO;
	}

	@Override
	public List<String> getAllStatesNames() {
		System.out.println("SSAAppServiceImpl.getAllStateByNames()");
		List<String> list = new ArrayList<String>();
		List<SSAAppStateEntity> stateEntity = ssaStateRepository.findAll();

		if (!stateEntity.isEmpty()) {
			for (SSAAppStateEntity entity : stateEntity) {
				list.add(entity.getStateName());
			}

		}
		return list;
	}

	@Override
	public String findStateBySsn(Long ssn) {
		String stateName = null;
		try {
			SSAAppEntity optionalEntity = ssaRepository.findOne(ssn);

			stateName = optionalEntity.getState();
			if (stateName != null)
				return stateName;

			else
				// throw custom exception
				throw new SsaAppRestException("SSn Number is Not Valid Please Try Again.....!!");

			/*
			 * if(optionalEntity.equals(stateName)) SSAAppEntity entity= optional
			 */
		} catch (Exception e) {
			// throw custom exception
			throw new SsaAppRestException("SSn Number is Not Valid Please Try Again.....!!");
		}
	}
}
