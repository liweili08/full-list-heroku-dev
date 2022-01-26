
import axios from 'axios'

export const getShoppingLists=()=>
    axios
        .get("/api/lists")
        .then(response=> response.data)


export const addItem=(newItem)=>
    axios
        .post("/api/lists",newItem)
        .then(response=> response.data)


export const putQuantityPlus=(itemKey)=>
    axios
        .put(`/api/lists/${itemKey}`)
        .then(response=> response.data)



export const putQuantityMinus=(itemKey)=>
    axios
        .put(`/api/lists/${itemKey}/decrease`)
        .then(response=> response.data)



export const deleteItem=(itemKey)=>
    axios
        .delete(`/api/lists/${itemKey}`)
        .then(response=>response.data)