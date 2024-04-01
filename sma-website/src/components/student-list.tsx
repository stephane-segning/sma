import {useStudent} from "../hooks/api-context/hook.ts";
import {useEffect, useState} from "react";
import {Student} from "@rtb";
import {Eye, PenTool, Trash} from 'react-feather';
import {Link} from "react-router-dom";

export function StudentList() {
    const [students, setstudents] = useState<Student[]>([]);
    const api = useStudent();

    useEffect(() => {
        api.getStudents()
            .then((response) => {
                setstudents(response.data);
            })
            .catch(reason => {
                console.error('Could not load student', reason.message);
            });
    }, [api]);

    return (
        <div className="overflow-x-auto">
            <table className="table">
                <thead>
                <tr>
                    <th></th>
                    <th>Name</th>
                    <th></th>
                </tr>
                </thead>
                <tbody>
                {students.map((student) => (
                    <tr key={student.id}>
                        <th>{student.id}</th>
                        <td>{student.name}</td>
                        <td className='flex gap-2'>
                            <Link to={student.id!} className="btn btn-sm btn-circle btn-ghost">
                                <Eye/>
                            </Link>
                            <Link to={`${student.id}/edit`} className="btn btn-sm btn-circle btn-ghost text-primary">
                                <PenTool/>
                            </Link>
                            <button className="btn btn-sm btn-circle btn-ghost text-error">
                                <Trash/>
                            </button>
                        </td>
                    </tr>
                ))}
                </tbody>
            </table>
        </div>
    );
}