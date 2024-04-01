import {Link} from "react-router-dom";
import {Plus} from "react-feather";
import {StudentList} from "../components/student-list.tsx";
import {PageWrapper} from "../components/page-wrapper.tsx";

export function StudentsScreen() {
    return (
        <PageWrapper title='Students' rightTitle={(
            <Link to='add' className='btn btn-primary'>
                <Plus className='mr-2'/>
                Add Student
            </Link>
        )}>
            <StudentList/>
        </PageWrapper>
    );
}