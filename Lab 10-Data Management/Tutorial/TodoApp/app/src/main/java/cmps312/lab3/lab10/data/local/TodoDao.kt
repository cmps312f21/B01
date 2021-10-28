package cmps312.lab3.lab10.data.local

import androidx.lifecycle.LiveData
import cmps312.lab3.lab10.data.local.entity.Project
import cmps312.lab3.lab10.data.local.entity.Todo

interface TodoDao{
    fun getProjects(): LiveData<List<Project>>
    fun getTodos(pid : Int): LiveData<List<Todo>>

    suspend fun addProject(project: Project)
    suspend fun deleteProject(project: Project)
    suspend fun getTodo(id: Int): Todo
    suspend fun addTodo(todo: Todo) : Long
    suspend fun updateTodo(todo: Todo)
    suspend fun deleteTodo(todo: Todo): Int

}