class ShoppingService {

    getListName() {
        return 'Shopping List';
    }

    getShoppingList() {
        return [
            {
                id: 1,
                title: '5 lb sack of potatoes',
                quantity: 1,
                isComplete: false
            },
            {
                id: 2,
                title: 'Frozen Pizza',
                quantity: 4,
                isComplete: true
            }
            ,
            {
                id: 3,
                title: 'Apples',
                quantity: 6,
                isComplete: true
            }
            ,
            {
                id: 4,
                title: 'Cereal',
                quantity: 1,
                isComplete: false
            }
            ,
            {
                id: 5,
                title: 'Milk',
                quantity: 1,
                isComplete: true
            }
            ,
            {
                id: 6,
                title: 'Yogurt',
                quantity: 5,
                isComplete: false
            }
            ,
            {
                id: 7,
                title: 'Bagels',
                quantity: 8,
                isComplete: false
            }
            ,
            {
                id: 8,
                title: 'Pasta Sauce',
                quantity: 2,
                isComplete: true
            }
            ,
            {
                id: 9,
                title: 'Onions',
                quantity: 3,
                isComplete: true
            }
            ,
            {
                id: 10,
                title: 'Ice Cream',
                quantity: 4,
                isComplete: false
            }
        ];
    }
}