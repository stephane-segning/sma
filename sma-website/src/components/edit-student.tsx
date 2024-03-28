import {useStudent} from "../hooks/api-context/hook.ts";
import {Student} from "@rtb";

interface EditStudentProps {
    id?: string; // If we have an ID, then we have the student. If not, we're a creating.
}

export function EditStudent({id}: EditStudentProps) {
    const {updateStudent, createStudent} = useStudent();
    const writeStudent = async (student: Student) => {
        const result =  await (id ? updateStudent(id, student) : createStudent(student));
    }

    return (
        <div>
            Create Student component
        </div>
    )
}