SELECT
  products.name AS "Top two products",
  categories.name
FROM products, orders, categories, purchaseitems
WHERE purchaseitems.order_id = orders.id &&
      products.category_id = 1 &&
      products.category_id = categories.id &&
      purchaseitems.product_id = products.id &&
      (orders.date >= '2016-03-08 00:00' || orders.date <= '2016-03-11 00:00:00')
GROUP BY products.name, categories.name
ORDER BY product_id
LIMIT 2;

