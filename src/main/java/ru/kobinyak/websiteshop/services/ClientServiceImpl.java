package ru.kobinyak.websiteshop.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.kobinyak.websiteshop.data.ClientRepositiry;
import ru.kobinyak.websiteshop.models.Client;

import javax.transaction.Transactional;

@Service
@Transactional
public class ClientServiceImpl implements ClientService {
    @Autowired
    private ClientRepositiry clientRepositiry;
    @Override
    public void save(Client client) {
        clientRepositiry.save(client);
    }
}
