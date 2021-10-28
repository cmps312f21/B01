package cmps312.lab3.lab10.data.repository;

import android.content.Context
import androidx.lifecycle.LiveData
import cmps312.lab3.lab10.data.local.TodoDatabase
import cmps312.lab3.lab10.data.local.entity.ProjectWithTodos
import cmps312.lab3.lab10.data.local.entity.Project
import cmps312.lab3.lab10.data.local.entity.Todo

class TodoListRepo(private val context: Context) {
    private val todoDao by lazy {
        TodoDatabase
            .getDatabase(context)
            .todoDao()
    }
    fun getProjects(): LiveData<List<Project>> = todoDao.getProjects()
    fun getTodos(pid: Int): LiveData<List<Todo>> = todoDao.getTodos(pid)
    fun getProjectWithTodos(): List<ProjectWithTodos> = todoDao.getProjectWithTodos()
    suspend fun addProject(project: Project) = todoDao.addProject(project)
    suspend fun deleteProject(project: Project) = todoDao.deleteProject(project)
    suspend fun getTodo(id: Int): Todo = todoDao.getTodo(id)
    suspend fun addTodo(todo: Todo): Long = todoDao.addTodo(todo)
    suspend fun updateTodo(todo: Todo) = todoDao.updateTodo(todo)
    suspend fun deleteTodo(todo: Todo): Int = todoDao.deleteTodo(todo)

}