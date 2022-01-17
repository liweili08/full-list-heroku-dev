
import axios from 'axios'

export const getShoppingLists=()=>
    axios
        .get("/api/lists")
        .then(response=> response.data)
