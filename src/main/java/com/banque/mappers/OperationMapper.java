package com.banque.mappers;

import com.banque.dataTransferObjects.OperationDto;
import com.banque.model.Operation;

public class OperationMapper {

    public static OperationDto toDto(Operation operation) {
        if (operation == null) { return null; }
        OperationDto dto = new OperationDto(
                operation.getId(),
                operation.getLibelle(),
                operation.getType(),
                operation.getDateOperation(),
                operation.getMontant()
        );
        return dto;
    }

    public static Operation toEntity(OperationDto dto) {
        if (dto == null) { return null; }
        Operation op = new Operation();
        op.setId(dto.getId());
        op.setType(dto.getTypeOperation());
        op.setDateOperation(dto.getDateOperation());
        op.setMontant(dto.getMontant());
        return op;
    }
}
