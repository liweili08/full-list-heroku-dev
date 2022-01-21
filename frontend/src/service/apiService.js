
import axios from 'axios'

export const getShoppingLists=()=>
    axios
        .get("/api/lists")
        .then(response=> response.data)


export const addItem=(newItem)=>
    axios
        .post("/api/lists",newItem)
        .then(response=> response.data)

export const putQuantityPlus=(itemQuantity)=>
    axios
        .put("/api/lists/{itemKey}",itemQuantity)
        .then(response=> response.data.get(itemQuantity))



//export const deleteItem=(itemKey)=>
//     axios
//         .delete("/api/lists",itemToDelete)
//         .then(response=>response.data)