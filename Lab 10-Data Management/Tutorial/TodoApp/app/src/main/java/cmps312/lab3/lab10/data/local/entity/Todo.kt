package cmps312.lab3.lab10.data.local.entity

import androidx.room.*

//One to Many [One projecet can have many stodos]
//this will enforce to not have inconsitent ID for a project.

@Entity(
    foreignKeys = [
        ForeignKey(entity = Project::class,
            parentColumns = ["id"],
            childColumns = ["pid"],
            onUpdate = ForeignKey.CASCADE,
            onDelete = ForeignKey.CASCADE
        )
    ]
)
data class Todo(
    var title: String? = null,
    var priority: String? = null,

    @ColumnInfo(index = true)
    var pid: Int,
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
)
