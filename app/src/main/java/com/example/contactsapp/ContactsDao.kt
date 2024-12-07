package com.example.contactsapp

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Query
import androidx.room.Upsert
import kotlinx.coroutines.flow.Flow

@Dao
interface ContactsDao {

    @Upsert
    suspend fun addContact(contact: Contact)

    @Delete
    suspend fun deleteContact(contact: Contact)

    @Query("SELECT * FROM CONTACT ORDER BY first_name ASC")
    fun getContactListByFirstName(): Flow<List<Contact>>

    @Query("SELECT * FROM CONTACT ORDER BY last_name ASC")
    fun getContactListByLastName(): Flow<List<Contact>>

    @Query("SELECT * FROM CONTACT ORDER BY phone_number ASC")
    fun getContactListByPhoneNumber(): Flow<List<Contact>>
}