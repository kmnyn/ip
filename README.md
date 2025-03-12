# Kate - User Guide

Welcome to **Kate**, your personal task management chatbot! Kate helps you keep track of your tasks efficiently with simple commands. This guide will help you understand how to use Kate effectively.

## Features

### 1. Adding a Task
You can add three types of tasks: **To-Do, Deadline, and Event**.

#### To-Do Task
- **Command:** `todo [Task Name]`
- **Example:**
  ```
  todo Task A
  ```
  **Response:**
  ```
  ____________________________________________________________
  Got it. I've added this task:
    [T][ ] Task A
  Now you have 1 task in the list.
  ____________________________________________________________
  ```

#### Deadline Task
- **Command:** `deadline [Task Name] /by [dd/MM/yyyy HHmm]`
- **Example:**
  ```
  deadline Task B /by 14/03/2025 2359
  ```
  **Response:**
  ```
  ____________________________________________________________
  Got it. I've added this task:
    [D][ ] Task B (by: 2025-03-14 23:59)
  Now you have 2 tasks in the list.
  ____________________________________________________________
  ```

#### Event Task
- **Command:** `event [Task Name] /from [dd/MM/yyyy HHmm] /to [dd/MM/yyyy HHmm]`
- **Example:**
  ```
  event Task C /from 13/03/2025 2359 /to 14/03/2025 2359
  ```
  **Response:**
  ```
  ____________________________________________________________
  Got it. I've added this task:
    [E][ ] Task C (from: 2025-03-13 23:59 to: 2025-03-14 23:59)
  Now you have 3 tasks in the list.
  ____________________________________________________________
  ```

---

### 2. Listing All Tasks
- **Command:** `list`
- **Example:**
  ```
  list
  ```
  **Response:**
  ```
  1. [T][ ] Task A
  2. [D][ ] Task B (by: 2025-03-14 23:59)
  3. [E][ ] Task C (from: 2025-03-13 23:59 to: 2025-03-14 23:59)
  ```

---

### 3. Deleting a Task
- **Command:** `delete [Task Number]`
- **Example:**
  ```
  delete 3
  ```
  **Response:**
  ```
  ____________________________________________________________
  Noted. I've removed this task:
    [E][ ] Task C (from: 2025-03-13 23:59 to: 2025-03-14 23:59)
  Now you have 2 tasks in the list.
  ____________________________________________________________
  ```

---

### 4. Marking a Task as Done
- **Command:** `mark [Task Number]`
- **Example:**
  ```
  mark 1
  ```
  **Response:**
  ```
  ____________________________________________________________
  Nice! I've marked this task as done:
    [T][X] Task A
  ____________________________________________________________
  ```

---

### 5. Marking a Task as Not Done
- **Command:** `unmark [Task Number]`
- **Example:**
  ```
  unmark 1
  ```
  **Response:**
  ```
  ____________________________________________________________
  Nice! I've unmarked this task as not done:
    [T][ ] Task A
  ____________________________________________________________
  ```

---

### 6. Finding a Task
- **Command:** `find [Keyword]`
- **Example:**
  ```
  find B
  ```
  **Response:**
  ```
  1. [D][ ] Task B (by: 2025-03-14 23:59)
  ```

---

### 7. Exiting the Program
- **Command:** `bye`
- **Example:**
  ```
  bye
  ```
  **Response:**
  ```
  Bye! Have a nice day!
  ```

---

## Summary of Commands
| Command | Description |
|---------|-------------|
| `todo [Task Name]` | Add a to-do task |
| `deadline [Task Name] /by [dd/MM/yyyy HHmm]` | Add a task with a deadline |
| `event [Task Name] /from [dd/MM/yyyy HHmm] /to [dd/MM/yyyy HHmm]` | Add an event with a start and end time |
| `list` | Show all tasks |
| `delete [Task Number]` | Remove a task from the list |
| `mark [Task Number]` | Mark a task as done |
| `unmark [Task Number]` | Mark a task as not done |
| `find [Keyword]` | Find tasks containing a keyword |
| `bye` | Exit the chatbot |

---

Thank you for using **Kate**! 🚀
