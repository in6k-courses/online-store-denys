SELECT products.name, categories.name
FROM categories, orders, products, purchaseitems
WHERE products.category_id = categories.id &&
  purchaseitems.product_id = products.id &&
  purchaseitems.order_id = orders.id
GROUP BY products.name
ORDER BY products.name ASC, categories.name ASC;
