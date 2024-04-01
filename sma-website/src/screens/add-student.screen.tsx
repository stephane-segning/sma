import {EditStudent} from "../components/edit-student.tsx";
import {PageWrapper} from "../components/page-wrapper.tsx";

export function AddStudentScreen() {
    return (
        <PageWrapper title='Add Student'>
            <h2>Create Student component</h2>
            <EditStudent />
        </PageWrapper>
    );
}