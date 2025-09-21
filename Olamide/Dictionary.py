DEPARTMENT_COURSES = {
    "Math", "Physics", "Computer Science", "Biology", "Chemistry",
    "Statistics", "English", "Economics", "History", "Philosophy",
    "Sociology", "Political Science", "Geography", "Psychology", "Art",
    "Music", "Engineering", "Law", "Medicine", "Business"
}

Students = {}
  
def create(username, name, age, courses, city, zip_code):
	"""Create and add a new student to the system."""	
	if username in Students:
		print( "Username already exists! Choose another one.")
		return
	valid_courses = {course for course in courses if course in DEPARTMENT_COURSES}
	student_details = {
        "name": name,
        "age": age,
        "courses": valid_courses,
        "address": {
            "city": city,
            "zip_code": zip_code
             }
    	}
	Students[username] = student_details	
	print(f" student'{username}' added successfully")

def display_student(username):
    """1. Display a student record in whole."""
    student = Students.get(username)
    if student:
        print(f"\n--- Student Record ({username}) ---")
        for key, value in student.items():
            print(f"{key.capitalize()}: {value}")
    else:
        print(" We can't find the student.")


def display_courses(username):
    """2. Display all courses a student is offering."""
    student = Students.get(username)
    if student:
        print(f"{student['name']}'s Courses: {student['courses']}")
    else:
        print("We can't find the student.")


def display_zip(username):
    """3. Display only the student’s zip code."""
    student = Students.get(username)
    if student:
        print(f"{student['name']}'s Zip Code: {student['address']['zip_code']}")
    else:
        print("We can't find the student.")


def display_city(username):
    """4. Display only the student’s city."""
    student = Students.get(username)
    if student:
        print(f"{student['name']}'s City: {student['address']['city']}")
    else:
        print("We can't find the student.")


def add_course(username, course):
    """5. Add a new course (only if valid and not duplicate)."""
    student = Students.get(username)
    if student:
        if course not in DEPARTMENT_COURSES:
            print("Invalid course. Not offered by department.")
        elif course in student['courses']:
            print("Student already enrolled in this course.")
        else:
            student['courses'].add(course)
            print(f"{course} added to {student['name']}'s courses.")
    else:
        print("We can't find the student.")




def update_or_remove_course(username, old_course, new_course=None):
    """6. Remove or update a course."""
    student = Students.get(username)
    if student:
        if old_course not in student['courses']:
            print("Course not found in student's record.")
            return
        if new_course: 
            if new_course not in DEPARTMENT_COURSES:
                print(" Invalid new course.")
            else:
                student['courses'].remove(old_course)
                student['courses'].add(new_course)
                print(f" {old_course} updated to {new_course}.")
        else:  
            student['courses'].remove(old_course)
            print(f"{old_course} removed from {student['name']}'s courses.")
    else:
        print("We can't find the student..")


def update_student(username, name=None, age=None, city=None, zip_code=None):
    """7. Update student's fields."""
    student = Students.get(username)
    if student:
        if name: student["name"] = name
        if age: student["age"] = age
        if city: student["address"]["city"] = city
        if zip_code: student["address"]["zip_code"] = zip_code
        print(f" {username}'s record updated successfully!")
    else:
        print("We can't find the student.")


def total_students():
    """8. Display total number of students in the system."""
    print(f" Total Students: {len(Students)}")
    return len(Students)

if __name__ == "__main__":
    
    create("Sade22", "Sade Segun", 22, {"Math", "Physics"}, "Lagos", "100001")

    display_student("Sade22")
    display_courses("Sade22")
    display_zip("Sade22")
    display_city("Sade22")

    add_course("Sade22", "Biology")
    update_or_remove_course("Sade22", "English", "Philosophy")
    update_student("Sade22", age=28, city="Ibadan")

    total_students()