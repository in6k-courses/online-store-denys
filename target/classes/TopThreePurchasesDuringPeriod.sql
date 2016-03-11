SELECT products.name AS "Top three products", categories.name
FROM products, orders, categories, purchaseitems
WHERE purchaseitems.order_id = orders.id &&
      categories.id = products.id &&
      purchaseitems.product_id = products.id &&
      (orders.date >= '2016-03-09 00:00' || orders.date <= '2016-03-11 00:00:00')
GROUP BY categories.name
ORDER BY product_id
LIMIT 3;

