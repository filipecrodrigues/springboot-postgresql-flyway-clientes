package io.github.filipecrodrigues.repository;

import io.github.filipecrodrigues.entity.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {
}
