package io.github.filipecrodrigues.repository.Cliente;

import io.github.filipecrodrigues.entity.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface Repository extends JpaRepository<Cliente, Long> {
}
