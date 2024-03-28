import {Plus} from 'react-feather';
import {StaffList} from "../components/staff-list.tsx";
import {Link} from "react-router-dom";


export function StaffsScreen() {
    return (
        <div className='container px-2 mt-2 mx-auto'>
            <div className='flex justify-between gap-4'>
                <h1 className='text-4xl font-bold'>Staffs</h1>

                <Link to='add' className='btn btn-primary'>
                    <Plus className='mr-2'/>
                    Add Staff
                </Link>
            </div>

            <StaffList/>
        </div>
    );
}