import { defineStore } from "pinia";

export const useUserStore = defineStore("userStore", {
    state: () => ({
        name: '',
        age: '',
        gender: '',
        location: '',
        lastOnline: '',
        joined: '',
        description: '',
        finished: [],
        read: [],
        favorites: [],
        readLater: []
    }),
    actions: {
        async getUser() {
            const user = await fetch('/api/manhwaLab/profile', {
                headers: {
                    'Authorization': localStorage.getItem('token')
                }
            })

        }
    }
})
