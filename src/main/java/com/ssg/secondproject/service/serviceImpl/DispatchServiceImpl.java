package com.ssg.secondproject.service.serviceImpl;

import com.ssg.secondproject.dto.DispatchDTO;
import com.ssg.secondproject.dto.response.PageResponseDTO;
import com.ssg.secondproject.mapper.DispatchMapper;
import com.ssg.secondproject.service.DispatchService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class DispatchServiceImpl implements DispatchService {
    private final DispatchMapper dispatchMapper;

    @Override
    public PageResponseDTO<DispatchDTO> getById(int id) {
        DispatchDTO dispatchData = dispatchMapper.findById(id);
        PageResponseDTO pageResponseDTO = PageResponseDTO.builder().data(dispatchData).build();
        return pageResponseDTO;
    }

    //할당량을 더해주기 때문에 transaction을 걸었음.
    @Transactional
    @Override
   // public void update(DispatchDTO dispatchDTO) {
    public void update(int outboundId, int vehicleId, String vehicleType) {

        //배차 수정하기
//        dispatchMapper.updateDispatch(dispatchDTO);


        //배차 등록하기
        dispatchMapper.insertDispatch(outboundId, vehicleId, vehicleType);
        //바로 승인해주기, 나중에는 배송기사가 승인해주는 것으로 추가하기
        //승인 트리거 사용. 배차 등록시 트리거로 상태 approved로 바꿔주기
        dispatchMapper.updateDispatchApproval(outboundId, vehicleId, vehicleType);

        //배차 할당량 증가시키기.
//       dispatchMapper.updateVehicleAllocation(dispatchDTO.getOutboundId(), dispatchDTO.getVehicleId(), dispatchDTO.getVehicleType());
        dispatchMapper.updateVehicleAllocation(outboundId, vehicleId, vehicleType);

        //배차량이 80%이상이면 배송 시작

    }
}