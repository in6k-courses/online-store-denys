#select order_id, (select sum(price)), date
SELECT orders.id AS "order_num",
        (SELECT SUM(purchaseitems.price * purchaseitems.amount)
        FROM purchaseitems
        WHERE purchaseitems.order_id = order_num
        ) AS total_cost,
        orders.date
FROM orders
GROUP BY orders.id;


