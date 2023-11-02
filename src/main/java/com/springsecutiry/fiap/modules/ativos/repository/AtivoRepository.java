package com.springsecutiry.fiap.modules.ativos.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springsecutiry.fiap.modules.ativos.entity.Ativo;

public interface AtivoRepository extends JpaRepository<Ativo, UUID> {

}
