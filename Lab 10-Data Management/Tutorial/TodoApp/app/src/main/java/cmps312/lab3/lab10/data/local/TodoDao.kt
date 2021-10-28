package cmps312.lab3.lab10.data.local

import androidx.lifecycle.LiveData
import androidx.room.*
import cmps312.lab3.lab10.data.local.entity.ProjectWithTodos
import cmps312.lab3.lab10.data.local.entity.Project
import cmps312.lab3.lab10.data.local.entity.Todo

@Dao
interface TodoDao {
    @Query("SELECT * FROM Project")
    fun getProjects(): LiveData<List<Project>>

    @Query("SELECT * FROM Todo WHERE pid=:pid")
    fun getTodos(pid: Int): LiveData<List<Todo>>

    @Transaction
    @Query("SELECT * FROM Project")
    fun getProjectWithTodos() : List<ProjectWithTodos>

    @Insert
    suspend fun addProject(project: Project)

    @Delete
    suspend fun deleteProject(project: Project)

    @Query("SELECT * FROM Todo WHERE id=:id")
    suspend fun getTodo(id: Int): Todo

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun addTodo(todo: Todo): Long

    @Update
    suspend fun updateTodo(todo: Todo)

    @Delete
    suspend fun deleteTodo(todo: Todo): Int

}