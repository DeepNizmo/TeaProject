package com.spring.henallux.teaProject.dataAccess.dao;

import com.spring.henallux.teaProject.dataAccess.entity.OrderEntity;
import com.spring.henallux.teaProject.dataAccess.entity.OrderLineEntity;
import com.spring.henallux.teaProject.dataAccess.repository.OrderLineRepository;
import com.spring.henallux.teaProject.dataAccess.repository.OrderRepository;
import com.spring.henallux.teaProject.dataAccess.util.ProviderConverter;
import com.spring.henallux.teaProject.model.*;
import org.springframework.stereotype.Service;

@Service
public class OrderDAO implements OrderDataAccess{
    private OrderRepository orderRepository;
    private OrderLineRepository orderLineRepository;
    private ProviderConverter providerConverter;

    public OrderDAO(OrderRepository orderRepository, OrderLineRepository orderLineRepository, ProviderConverter providerConverter) {
        this.orderRepository = orderRepository;
        this.orderLineRepository = orderLineRepository;
        this.providerConverter = providerConverter;
    }

    @Override
    public void saveOrder(Cart cart, Order order) {
        OrderEntity orderEntity;
        orderEntity = providerConverter.orderModelToOrderEntity(order);
        orderRepository.save(orderEntity);
        for (CartItem item: cart.getItems().values()) {
            OrderLineEntity orderLineEntity = new OrderLineEntity();
            orderLineEntity.setOrder(orderEntity);
            Product product = new Product(item.getId(), item.getName(), item.getUnitPrice(), item.getDetails(), item.getCategory(), item.getReducedPrice());
            orderLineEntity.setProduct(providerConverter.productModelToProductEntity(product));
            orderLineEntity.setQuantity(item.getQuantity());
            orderLineEntity.setOrderPrice(item.getActualPrice());
            orderLineRepository.save(orderLineEntity); //return quelque chose ??
        }
    }
}