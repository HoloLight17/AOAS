package ru.ithub.aoas.services.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import ru.ithub.aoas.domain.entity.Client;
import ru.ithub.aoas.domain.mapper.ClientMapper;
import ru.ithub.aoas.domain.repository.ClientRepository;
import ru.ithub.aoas.exceptions.NotFoundException;
import ru.ithub.aoas.payload.response.ClientDto;
import ru.ithub.aoas.services.ClientService;

import java.util.Collection;

@Service
@RequiredArgsConstructor
class ClientServiceImpl implements ClientService {
    private final ClientRepository clientRepository;
    private final ClientMapper clientMapper;

    @Override
    public ClientDto getById(Long id) {
        return clientMapper.toDto(
                clientRepository.findById(id)
                        .orElseThrow(() -> new NotFoundException(Client.class, id))
        );
    }

    @Override
    public Page<ClientDto> getAll(int page, int size) {
        Page<Client> pageEntity = clientRepository.findAll(PageRequest.of(page, size));

        return new PageImpl<>(
                clientMapper.toDto(pageEntity.toList()),
                PageRequest.of(page, size),
                pageEntity.getTotalElements()
        );
    }

    @Override
    public ClientDto create(ClientDto dto) {
        return clientMapper.toDto(
                clientRepository.save(
                        clientMapper.toEntity(dto)
                )
        );
    }

    @Override
    public ClientDto update(Long id, ClientDto dto) {
        Client entity = clientRepository.findById(id).orElseThrow(() -> new NotFoundException(Client.class, id));
        clientMapper.update(dto, entity);

        return clientMapper.toDto(
                clientRepository.save(
                        entity
                )
        );
    }

    @Override
    public void delete(Collection<Long> ids) {
        clientRepository.deleteAllById(ids);
    }
}
